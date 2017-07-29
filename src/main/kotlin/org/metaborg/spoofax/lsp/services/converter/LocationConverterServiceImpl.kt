package org.metaborg.spoofax.lsp.services.converter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.lsp4j.Location
import org.metaborg.core.source.ISourceLocation
import org.metaborg.spoofax.lsp.services.workspace.VirtualWorkspaceFileObject
import org.slf4j.Logger

@Singleton
class LocationConverterServiceImpl(
        val rangeConverterService: RangeConverterService
) : LocationConverterService {

    @Inject
    lateinit var logger : Logger

    override fun convert(from: ISourceLocation?): Location {
        return from?.run {
            val document = (resource() as VirtualWorkspaceFileObject).document
            Location(
                document?.remote,
                rangeConverterService.convert(region())
            )
        } ?: Location().apply {
            logger.warn("Supplied ISourceLocation is null! Returning default {}", this)
        }
    }
}