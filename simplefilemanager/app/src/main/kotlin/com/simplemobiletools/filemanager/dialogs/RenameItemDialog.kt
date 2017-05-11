package com.simplemobiletools.filemanager.dialogs

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.WindowManager
import com.simplemobiletools.filemanager.Config
import com.simplemobiletools.filemanager.R
import com.simplemobiletools.filepicker.extensions.*
import com.simplemobiletools.filepicker.models.FileDirItem
import kotlinx.android.synthetic.main.rename_item.view.*
import java.io.File

class RenameItemDialog(val context: Context, val path: String, val item: FileDirItem, val listener: OnRenameItemListener) {

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.rename_item, null)
        view.item_name.setText(item.name)

        AlertDialog.Builder(context)
                .setTitle(context.resources.getString(R.string.rename_item))
                .setView(view)
                .setPositiveButton(R.string.ok, null)
                .setNegativeButton(R.string.cancel, null)
                .create().apply {
            window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            show()
            getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
                val newName = view.item_name.value
                if (newName.isAValidFilename()) {
                    val currFile = File(path, item.name)
                    val newFile = File(path, newName)

                    if (newFile.exists()) {
                        context.toast(R.string.name_taken)
                        return@setOnClickListener
                    }

                    if (context.needsStupidWritePermissions(path)) {
                        val document = context.getFileDocument(currFile.absolutePath, Config.newInstance(context).treeUri)
                        if (document.canWrite())
                            document.renameTo(newName)
                        sendSuccess(currFile, newFile)
                        dismiss()
                    } else {
                        if (currFile.renameTo(newFile)) {
                            sendSuccess(currFile, newFile)
                            dismiss()
                        } else {
                            context.toast(R.string.error_occurred)
                        }
                    }
                } else {
                    context.toast(R.string.invalid_name)
                }
            })
        }
    }

    private fun sendSuccess(currFile: File, newFile: File) {
        context.scanFiles(arrayListOf(currFile, newFile)) {}
        listener.onSuccess()
    }

    interface OnRenameItemListener {
        fun onSuccess()
    }
}
