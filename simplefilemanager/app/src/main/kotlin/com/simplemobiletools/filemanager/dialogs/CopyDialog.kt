package com.simplemobiletools.filemanager.dialogs

import android.support.v4.util.Pair
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.WindowManager
import com.simplemobiletools.filemanager.Config
import com.simplemobiletools.filemanager.R
import com.simplemobiletools.filemanager.activities.SimpleActivity
import com.simplemobiletools.filepicker.asynctasks.CopyMoveTask
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog
import com.simplemobiletools.filepicker.extensions.humanizePath
import com.simplemobiletools.filepicker.extensions.isPathOnSD
import com.simplemobiletools.filepicker.extensions.scanFiles
import com.simplemobiletools.filepicker.extensions.toast
import kotlinx.android.synthetic.main.copy_item.view.*
import java.io.File
import java.util.*

class CopyDialog(val activity: SimpleActivity, val files: ArrayList<File>, val copyMoveListener: CopyMoveTask.CopyMoveListener) {

    init {
        val context = activity
        val view = LayoutInflater.from(context).inflate(R.layout.copy_item, null)
        val sourcePath = files[0].parent.trimEnd('/')
        var destinationPath = ""
        view.source.text = "${context.humanizePath(sourcePath)}/"

        val config = Config.newInstance(context)
        view.destination.setOnClickListener {
            FilePickerDialog(activity, destinationPath, false, config.showHidden, object : FilePickerDialog.OnFilePickerListener {
                override fun onFail(error: FilePickerDialog.FilePickerResult) {
                }

                override fun onSuccess(pickedPath: String) {
                    destinationPath = pickedPath
                    view.destination.text = context.humanizePath(pickedPath)
                }
            })
        }

        AlertDialog.Builder(context)
                .setTitle(context.resources.getString(if (files.size == 1) R.string.copy_item else R.string.copy_items))
                .setView(view)
                .setPositiveButton(R.string.ok, null)
                .setNegativeButton(R.string.cancel, null)
                .create().apply {
            window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            show()
            getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
                if (destinationPath == context.resources.getString(R.string.select_destination) || destinationPath.isEmpty()) {
                    context.toast(R.string.please_select_destination)
                    return@setOnClickListener
                }

                if (view.source.text.trimEnd('/') == destinationPath.trimEnd('/')) {
                    context.toast(R.string.source_and_destination_same)
                    return@setOnClickListener
                }

                val destinationDir = File(destinationPath)
                if (!destinationDir.exists()) {
                    context.toast(R.string.invalid_destination)
                    return@setOnClickListener
                }

                if (files.size == 1) {
                    val newFile = File(files[0].path)
                    if (File(destinationPath, newFile.name).exists()) {
                        context.toast(R.string.already_exists)
                        return@setOnClickListener
                    }
                }

                if (activity.isShowingPermDialog(destinationDir)) {
                    return@setOnClickListener
                }

                if (view.dialog_radio_group.checkedRadioButtonId == R.id.dialog_radio_copy) {
                    context.toast(R.string.copying)
                    val pair = Pair<ArrayList<File>, File>(files, destinationDir)
                    CopyMoveTask(context, false, config.treeUri, false, copyMoveListener).execute(pair)
                    dismiss()
                } else {
                    if (context.isPathOnSD(sourcePath) || context.isPathOnSD(destinationPath)) {
                        context.toast(R.string.moving)
                        val pair = Pair<ArrayList<File>, File>(files, destinationDir)
                        CopyMoveTask(context, true, config.treeUri, false, copyMoveListener).execute(pair)
                        dismiss()
                    } else {
                        val updatedFiles = ArrayList<File>(files.size * 2)
                        updatedFiles.addAll(files)
                        for (file in files) {
                            val destination = File(destinationDir, file.name)
                            if (file.renameTo(destination))
                                updatedFiles.add(destination)
                        }

                        context.scanFiles(updatedFiles) {}
                        context.toast(R.string.moving_success)
                        dismiss()
                        copyMoveListener.copySucceeded(true, files.size * 2 == updatedFiles.size)
                    }
                }
            })
        }
    }
}
