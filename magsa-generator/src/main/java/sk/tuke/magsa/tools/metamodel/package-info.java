@Parser(
    className = "sk.tuke.magsa.tools.parserext.Parser",
    mainNode = "Model",
    tokens = {
        @TokenDef(name = "INTEGER", regexp = "integer"),
        @TokenDef(name = "REAL", regexp = "real"),
        @TokenDef(name = "STRING", regexp = "string"),

        @TokenDef(name = "NAME", regexp = "[a-zA-Z_][a-zA-Z0-9_]*"),
        @TokenDef(name = "INT_VALUE", regexp = "[-]?[0-9]+"),
        @TokenDef(name = "REAL_VALUE", regexp = "[-]?[0-9]+[.][0-9]*((e|E)[0-9]+)?"),
        @TokenDef(name = "STRING_VALUE", regexp = "\"(.*)\"")
    },
    skips = {
        @Skip("#.*\\n"), //comment
        @Skip(" "),
        @Skip("\\t"),
        @Skip("\\n"),
        @Skip("\\r"),
        @Skip("#.*")
    }
)
package sk.tuke.magsa.tools.metamodel;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
