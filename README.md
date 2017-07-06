# InkleJsonParser


This code converts .json from inklewriter (writer.inklestudios.com) into Java object. This code is useful for implementing interpreter for text games written in inklewriter tool by **inkle**: <https://writer.inklestudios.com/>

The basic funcionality is shown:
     

        StoryJsonParser parser = new StoryJsonParser();

        Story story = new Story();

        parser.parseStory(ConstantTestJsons.jsonMusgrave, story);

        story.printTheWholeStory();
        
Now the story object can be used for methods such as:

        Stitch stitch = story.getActualStitch();
        boolean b = story.isActualStitchDiverted();
