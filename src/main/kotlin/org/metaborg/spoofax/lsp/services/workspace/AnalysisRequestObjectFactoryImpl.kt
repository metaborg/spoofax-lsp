package org.metaborg.spoofax.lsp.services.workspace

import org.apache.commons.vfs2.FileObject
import org.metaborg.core.MetaborgException
import org.metaborg.core.language.ILanguageIdentifierService
import org.metaborg.core.project.ISimpleProjectService
import org.metaborg.spoofax.core.unit.ISpoofaxInputUnitService
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject
import org.slf4j.Logger
import javax.inject.Inject

class AnalysisRequestObjectFactoryImpl @Inject constructor(
        private val projectService: ISimpleProjectService,
        private val spoofaxInputUnitService: ISpoofaxInputUnitService,
        private val languageIdentifierService: ILanguageIdentifierService
): AnalysisRequestObjectFactory {

    @com.google.inject.Inject
    lateinit var logger : Logger

    override fun create(document: VirtualWorkspaceFileObject, root: FileObject): AnalysisRequestObject? {
        return try {
            AnalysisRequestObject(
                    spoofaxInputUnitService.inputUnit(
                            document,
                            document.document?.text ?: "",
                            languageIdentifierService.identify(document),
                            null
                    ),
                    null,
                    projectService[root]
            )
        } catch (ex : MetaborgException) {
            logger.error("Could not create request object with document {} and root {}, failed with {}",
                    document, root, ex).run { null }
        }
    }
}