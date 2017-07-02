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
class VirtualWorkspaceFileSystem(rootName: FileName?, fileSystemOptions: FileSystemOptions?)
    : AbstractFileSystem(rootName, null, fileSystemOptions) {

    override fun createFile(abstractFileName: AbstractFileName): FileObject {
        return VirtualWorkspaceFileObject(abstractFileName, this)
    }

    override fun addCapabilities(capabilities: MutableCollection<Capability>?) {

    }
}