package org.metaborg.spoofax.lsp.services.workspace

import org.apache.commons.io.input.ReaderInputStream
import org.apache.commons.vfs2.FileType
import org.apache.commons.vfs2.provider.AbstractFileName
import org.apache.commons.vfs2.provider.AbstractFileObject
import java.io.InputStream
import java.io.StringReader
import java.nio.charset.Charset

/**
 * A [VirtualWorkspaceFileObject] is an implementation of the [AbstractFileObject] class.
 *
 * This class specialises in keeping track of workspace documents.
 *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class VirtualWorkspaceFileObject(name: AbstractFileName?, fs: VirtualWorkspaceFileSystem?, var document: VirtualWorkspaceDocument? = null)
    : AbstractFileObject<VirtualWorkspaceFileSystem>(name, fs) {

    override fun doGetContentSize(): Long = document?.text?.length?.toLong() ?: -1

    override fun doGetInputStream(): InputStream {
        return ReaderInputStream(StringReader(document?.text), Charset.forName("UTF-16"))
    }

    override fun doListChildren(): Array<String> {
        TODO("not implemented")
    }

    override fun doGetType(): FileType {
        TODO("not implemented")
    }

}