![](https://raw.githubusercontent.com/jakimfett/Projektor/master/src/main/resources/assets/projektor/logo.png)

Blueprint based projector, originally part of Minechem

The Minechem projector is currently slated to be removed as part of the v6 update. It’s a beautiful piece of functionality, and I’d hate to see it get lost. I propose that we split the projector into its own mini mod.

Currently, the projector just projects a code-defined multiblock series of “ghost blocks” into the world, guiding the player to create a structure layer by layer.

Here’s the functional requirements for splitting it off:
* Ghost blocks should be defined by the block they are ghosting, not by special blocks we make.
* When in creative mode, GUI should provide a “build now” button, creating the entire structure.
* Blueprints should be defined by JSON and an API

Down the road, we want to be able to “scan” structures in the world. I was thinking a buildcraft quarry marker type thing...outline the space, right click with your “laser scanning unit” and then you feed it paper to output blueprints. Additionally, we should make a way to export to various “standard” minecraft formats...eg, mcedit.

Possibly add a “hard light holograph” projector that consumes power but makes the ghost blocks take a solid form, but break like glass (with no drop). So you could copy a house, and then project three copies of it for your friends.
