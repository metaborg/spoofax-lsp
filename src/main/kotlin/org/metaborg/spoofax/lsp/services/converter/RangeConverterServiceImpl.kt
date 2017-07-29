package org.metaborg.spoofax.lsp.services.converter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.metaborg.core.source.ISourceRegion
import org.slf4j.Logger

@Singleton
class RangeConverterServiceImpl : RangeConverterService {

    @Inject
    lateinit var logger : Logger

    override fun convert(from: ISourceRegion?): Range {
        return from?.run {
            Range(
                Position(startRow(), startColumn()),
                Position(endRow(), endColumn())
            )
        } ?: Range().apply {
            logger.warn("Supplied ISourceRegion was null! Returning default {}", this)
        }
    }
}