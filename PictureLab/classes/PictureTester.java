/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
   public static void testOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.onlyBlue();
    beach.explore();
  }
   public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }
  public static void testFixUnderwater()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.fixUnderwater();
    beach.explore();
  }
  public static void testScaleByHalf()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.scaleByHalf().explore();
  }
  public static void testScaleByX()
  {
    Picture beach = new Picture("kappa.jpg");
    beach.explore();
    beach.scaleByX(10).explore();
  }
  public static void testEnlargeByX()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.enlargeByX(2).explore();
  }
  public static void testMiniCollage()
  {
    Picture kappa = new Picture("kappa.jpg");
    kappa.explore();
    kappa.makeMiniCollage().explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  /** Method to test mirrorHorizontalBottomToTop */
  public static void testMirrorHorizontalBottomToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  public static void testMirrorSeagull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorSeagull();
    seagull.explore();
  }
  public static void testCropAndCop()
  {
    Picture seagull = new Picture("seagull.jpg");
    Picture fishies = new Picture("water.jpg");
    seagull.explore();
    seagull.cropAndCopy(fishies,0,150,150,462,0,0);
    seagull.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}