package org.metaborg.spoofax.lsp.services.workspace

import org.apache.commons.vfs2.Capability
import org.apache.commons.vfs2.FileName
import org.apache.commons.vfs2.FileObject
import org.apache.commons.vfs2.FileSystemOptions
import org.apache.commons.vfs2.provider.AbstractFileName
import org.apache.commons.vfs2.provider.AbstractFileSystem

/**
 * A [VirtualWorkspaceFileSystem] is an implementation of the [AbstractFileSystem] class specialising in resolving files
 * in a virtual workspace.
 *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class VirtualWorkspaceFileSystem(rootName: FileName?, parentLayer: FileObject?, fileSystemOptions: FileSystemOptions?)
    : AbstractFileSystem(rootName, parentLayer, fileSystemOptions) {

    override fun createFile(abstractFileName: AbstractFileName): FileObject {
        TODO("not implemented")
    }

    override fun addCapabilities(p0: MutableCollection<Capability>?) {
        TODO("not implemented")
    }
}