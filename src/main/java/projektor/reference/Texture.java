package projektor.reference;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jakimfett
 */
public class Texture
{
    public static final class IIcon
    {
        private static final String PREFIX = Naming.ID + ":";
        public static final String DUMMY = PREFIX + "dummyBlockIcon";
    }

    public static final class Model
    {

        private static final String MODEL_DIR = "textures/model/";
        public static final String PROJECTOR_ON = MODEL_DIR + "ProjectorModelOn.png";
        public static final String PROJECTOR_OFF = MODEL_DIR + "ProjectorModelOff.png";
    }

}
