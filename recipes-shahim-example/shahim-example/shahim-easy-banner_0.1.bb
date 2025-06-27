SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"


python do_display_banner() {
    bb.plain("***********************************************************");
    bb.plain("*        hello from                                        *");
    bb.plain("* ~/example_recipes/meta-myexamples/recipes-shahim-easy-ba *");
    bb.plain("*                                                          *");
    bb.plain("***********************************************************");
}

addtask display_banner before do_build