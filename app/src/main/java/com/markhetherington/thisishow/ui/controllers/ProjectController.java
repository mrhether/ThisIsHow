package com.markhetherington.thisishow.ui.controllers;

import com.markhetherington.thisishow.models.Instruction;
import com.markhetherington.thisishow.models.MaterialQuantityItem;
import com.markhetherington.thisishow.models.Project;
import com.markhetherington.thisishow.models.User;

import java.util.ArrayList;
import java.util.List;

public class ProjectController extends BaseViewController<ProjectController.ProjectControllerListener> {

    @Override
    protected void onListenerAdded() {
        Project project = createStubProject();
        inform(listener -> listener.onProjectChanged(project));
    }

    public interface ProjectControllerListener {
        void onProjectChanged(Project project);
    }

    public static Project createStubProject() {
        Project project = new Project();
        project.setTitle("Concrete Lamp");
        project.setDescription("This is for fun. A lamp from concrete easily can be made by yourself with quite simple tools and materials. Of course there are some steps must be noted to achieve good results. Exactly these steps I would like to show in a short video.\n" +
                "\n" +
                "I would be pleasured if you would share your experience of making the lamp of concrete with me.");
        project.setImageUrl("http://blog.catchmyparty.com/wp-content/uploads/2012/05/lampshade5.jpg");

        User creator = new User();
        creator.setUsername("liftyd");
        creator.setBio("Woodworking, sleeping, and coding. That is life.");
        creator.setImageUrl("https://i.stack.imgur.com/Q616U.jpg");

        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction() {{
            setTitle("The form");
            setDescriptionHtmlText("I made my form so that the lamp is L: 10cm B: 10cm H: 7cm. Its smart to make the walls higher than what you want it to be and make a straight line at the point where the concrete is going to stop.\n" +
                    "\n" +
                    "Poke a hole in one of the walls for the cable to go through.");
            setImageUrl("http://cdn.instructables.com/FDV/HRPI/IG6TYK6Y/FDVHRPIIG6TYK6Y.MEDIUM.jpg");
        }});
        for (int i = 0; i < 3; ++i) {
            final int finalI = i;
            instructions.add(new Instruction() {{
                setTitle("Lamp socket " + String.valueOf(finalI));
                setDescriptionHtmlText("In the picture you can see my lamp socket, I took it out from an old and broken lamp that I had.\n" +
                        "\n" +
                        "I pushed the cable through the tiny hole and placed the lamp socket where I wanted it to be and adjusted the cable length that was inside.");
                setImageUrl("http://cdn.instructables.com/FRQ/TQCI/IG6TYKBR/FRQTQCIIG6TYKBR.MEDIUM.jpg");
            }});
        }

        List<MaterialQuantityItem> materials = new ArrayList<>();
        MaterialQuantityItem materialQI = new MaterialQuantityItem();
        materialQI.getMaterial().setName("14x16cm wood");
        materialQI.setCount(4);
        materials.add(materialQI);

        MaterialQuantityItem materialQI2 = new MaterialQuantityItem();
        materialQI2.getMaterial().setName("14x14cm wood");
        materialQI2.setCount(1);
        materials.add(materialQI2);

        project.setMaterials(materials);

        project.setInstructions(instructions);


        return project;
    }
}
