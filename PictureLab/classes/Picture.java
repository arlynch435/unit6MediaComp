import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
   public void onlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
   public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }
   public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg=(pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
      }
    }
  }
   public void addXToAll(int x)
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(pixelObj.getRed()+x);
        pixelObj.setGreen(pixelObj.getGreen()+x);
        pixelObj.setBlue(pixelObj.getBlue()+x);
      }
    }
  }
   public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int blue=pixelObj.getBlue();
        int green=pixelObj.getGreen();
        pixelObj.setGreen(green-100);
        pixelObj.setBlue(blue-100);
      }
    }
  }
  public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, 
         int startSourceCol, int endSourceCol,
         int startDestRow, int startDestCol )
  {
      int rowinc=0;
      int colinc=0;
      for (int row = startSourceRow; row < endSourceRow; row++)
    {
      for (int col = startSourceCol; col < endSourceCol; col++)
      {
        Pixel sourcePixel = sourcePicture.getPixel(col,row);
        Pixel destPixel = this.getPixel(startDestCol+colinc,startDestRow+rowinc);
        colinc++;
        destPixel.setColor(sourcePixel.getColor());
      }
      rowinc++;
      colinc=0;
    } 
  }
  public Picture scaleByHalf()
  {
      Pixel[][] pixels=this.getPixels2D();
      int halfRow=pixels.length/2;
      int halfCol=pixels[0].length/2;
      Picture scaled= new Picture(halfRow,halfCol);
      Pixel[][] halfPixels=scaled.getPixels2D();
      Pixel oldPixel=null;
      Pixel newPixel=null;
      for (int row = 0; row < halfRow; row++)
      
    {
      for (int col = 0; col < halfCol; col++)
      {
        oldPixel=pixels[row*2][col*2];
        newPixel = halfPixels[row][col];
        newPixel.setColor(oldPixel.getColor());
      }
    }
      return scaled;
    }
    public Picture scaleByX(int x)
  {
      Pixel[][] pixels=this.getPixels2D();
      int pieceRow=pixels.length/x;
      int pieceCol=pixels[0].length/x;
      Picture scaled= new Picture(pieceRow,pieceCol);
      Pixel[][] piecePixels=scaled.getPixels2D();
      Pixel oldPixel=null;
      Pixel newPixel=null;
      for (int row = 0; row < pieceRow; row++)
    {
      for (int col = 0; col < pieceCol; col++)
      {
        oldPixel=pixels[row*x][col*x];
        newPixel = piecePixels[row][col];
        newPixel.setColor(oldPixel.getColor());
      }
    }
      return scaled;
    }
      public Picture enlargeByX(int x)
  {
      Pixel[][] pixels=this.getPixels2D();
      int pieceRow=pixels.length*x;
      int pieceCol=pixels[0].length*x;
      Picture scaled= new Picture(pieceRow,pieceCol);
      Pixel[][] piecePixels=scaled.getPixels2D();
      Pixel oldPixel=null;
      Pixel newPixel=null;
      for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        oldPixel=pixels[row][col];
        for (int i = 0; i<x; i++)
        {
          for (int j = 0; j<x; j++)
          {
            newPixel = piecePixels[(row*x)+i][(col*x)+j];
            newPixel.setColor(oldPixel.getColor());
          }
        }
      }
    }
      return scaled;
    }
   public void clearToWhite()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255);
        pixelObj.setGreen(255);
        pixelObj.setBlue(255);
      }
    }
  }
        public Picture makeMiniCollage()
  {
      Pixel[][] pixels=this.getPixels2D();
      int moddyRow=pixels.length/10;
      int moddyCol=pixels[0].length/10;
      int completeRow=moddyRow*pixels.length;
      int completeCol=moddyCol*pixels[0].length;
      Picture complete=new Picture(completeRow,completeCol);
      Pixel oldPixel=null;
      Pixel newPixel=null;
      for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        oldPixel=pixels[row][col];
        int grayLevel=oldPixel.getBlue();
        Picture modified= this.scaleByX(10);
        modified.addXToAll(grayLevel);
        complete.cropAndCopy(modified,0,moddyRow,0,moddyCol,row*moddyRow,col*moddyCol);

      }
    }
      return complete;
    }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from right to left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from top to bottom */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2 ; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from bottom to top */
  public void mirrorHorizontalBottomToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2 ; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorArms()
  {
    Pixel[][] pixels = this.getPixels2D();
    int tLeftRow= 158;
    int tLeftCol= 103;
    int bRightRow= 196;
    int bRightCol= 295;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int row = tLeftRow; row < bRightRow ; row++)
    {
      for (int col = tLeftCol; col < bRightCol; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[(bRightRow-row)+bRightRow][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
    }
    public void mirrorSeagull()
  {
    Pixel[][] pixels = this.getPixels2D();
    int tLeftRow= 235;
    int tLeftCol= 238;
    int bRightRow= 324;
    int bRightCol= 339;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    for (int row = tLeftRow; row < bRightRow ; row++)
    {
      for (int col = tLeftCol; col < bRightCol; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][(tLeftCol-col)+tLeftCol];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
    }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    //I believe this image should handle all the requirements. This program runs and saves the image made up of itself
    //initialise new picture
    Picture kappa=new Picture("kappa.jpg");
    Picture finalPic=kappa.makeMiniCollage();
    //Saves the final picture
    finalPic.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("seagull.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
