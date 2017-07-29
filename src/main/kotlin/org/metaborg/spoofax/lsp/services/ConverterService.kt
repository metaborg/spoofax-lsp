package org.metaborg.spoofax.lsp.services

/**
 * A Converter Service converts a Spoofax object to it's respective LSP object
 */
interface ConverterService<in F, out T> {

    /**
     * Converts the given object of type F to an object of type T.
     */
    fun convert(from : F) : T

}