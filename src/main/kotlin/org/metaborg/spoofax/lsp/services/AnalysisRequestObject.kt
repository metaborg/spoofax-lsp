package org.metaborg.spoofax.lsp.services

import org.apache.commons.vfs2.FileObject
import org.metaborg.spoofax.lsp.services.workspace.VirtualWorkspaceFileObject

/**
 * A Container object for two objects, a document file and a root object.
 */
class AnalysisRequestObject(val document : VirtualWorkspaceFileObject, val root : FileObject) {
}