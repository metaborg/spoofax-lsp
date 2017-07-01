package org.metaborg.spoofax.lsp.services.workspace

import org.apache.commons.vfs2.FileType
import org.apache.commons.vfs2.provider.AbstractFileName
import org.apache.commons.vfs2.provider.AbstractFileObject
import java.io.InputStream

/**
 * A [VirtualWorkspaceFileObject] is an implementation of the [AbstractFileObject] class.
 *
 * This class specialises in keeping track of workspace documents.
 *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class VirtualWorkspaceFileObject(name: AbstractFileName?, fs: VirtualWorkspaceFileSystem?)
    : AbstractFileObject<VirtualWorkspaceFileSystem>(name, fs) {

    override fun doGetContentSize(): Long {
        TODO("not implemented")
    }

    override fun doGetInputStream(): InputStream {
        TODO("not implemented")
    }

    override fun doListChildren(): Array<String> {
        TODO("not implemented")
    }

    override fun doGetType(): FileType {
        TODO("not implemented")
    }

}