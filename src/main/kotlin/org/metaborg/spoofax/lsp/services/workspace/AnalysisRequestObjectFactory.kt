package org.metaborg.spoofax.lsp.services.workspace

import org.apache.commons.vfs2.FileObject
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject

/**
 * Created by Thomas on 30-7-2017.
 */
interface AnalysisRequestObjectFactory {

    fun create(document: VirtualWorkspaceFileObject, root: FileObject): AnalysisRequestObject?

}