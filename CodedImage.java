import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CodedImage extends BufferedImage
{
    private boolean coded;              //Flag to identify if CodedImage object is coded or not coded.
    private int heightMod = 6;          //Indicates jump distance on x axis.
    private int widthMod = 6;           //Indicates jump distance on y axis.
    private int size;                   //Stores number amount of hidden material.
    private String filePath;	        //String containing user indicated file path.
    private String secretMsg;	        //String containing user indicated secret message.
    private BufferedImage currentImg;   //Reference to current working image.

    //Overloaded Constructor.
    public CodedImage(String pathName, boolean coded)
    {
        this.setPath(pathName);
        this.setFlag(coded);
        this.setBufferedImage();
        this.setSize();
    }
    
    //Open Image Method.
    public BufferedImage setBufferedImage()
    {
        this.currentImg = new ImageIO.read(new File(this.filePath));
        return(currentImg);
    }
    
    //Save file function.
    public static void save(BufferedImage img)
    {
        try 
        {
            File outFile = new File("save.jpg");
            ImageIO.write(img, "jpg", outFile);
        } catch (IOException e){}
    }
    
    //Set boolean flag.
    public void setFlag(boolean Indicater)
    {
        this.coded = userIndicate;
    }
    
    //Sets user instructed path name.
    public void setPath(String path)
    {
        this.filePath = path;
    }
    
    //This method returns int size which is the total amount of characters that can be stored.
    public static int setSize()
	{
		this.size = (this.getWidth() * this.getHeight()) / (heightMod * widthMod);
	}
    
    //Method to change secret instance variable.
    public void setSecret(String secret)
    {
        this.secretMsg = secret;
    }
    
    //Method to return secret instance variable.
    public String getSecret()
    {
        return(this.secretMsg);
    }
    
    //Encoding protocol.
    public CodedImage encode(CodedImage)
    {
        
    }
    
    //Decoding protocol.
    public void decode()
    {
        
    }
/* Legacy Code
    //Encoding Protocol.
    public static BufferedImage code(BufferedImage img)
	{
	    Scanner keyboard = new Scanner(System.in);
	    String input;
        
        System.out.print("Enter a message: ");
		input = keyboard.nextLine();
        
        String[] hexArray = charToHex(input);
        int hexCounter = 0;
        
        hexArray = colorKey(hexArray);
        
		for(int i = 0; i < img.getHeight(); i +=heightMod)
        {
			for(int j = 0; j < img.getWidth(); j +=widthMod)
            {   
                img.setRGB(j, i, hexStringToRGBInt(hexArray[hexCounter]));
                    
                if(hexCounter < (hexArray.length - 1))
                    hexCounter++;
            }
        }
        return(img);
	}
	
	//Decoding Protocol  
    public static String[] decode(BufferedImage img)
	{
        String[] hexArray = new String[calculateSize(img)];
        int hexCounter = 0;
        
		for(int i = 0; i < img.getHeight(); i += heightMod)
        {
			for(int j = 0; j < img.getWidth(); j += widthMod)
            {                
				String hexColor = Integer.toHexString(img.getRGB(j, i));
                hexArray[hexCounter] = hexColor;
                                            
                hexCounter++;
            }
        }
                
        return(hexArray);
	}
    
    //This is the initial modifier for preparing the String[] of hexcodes.
    public static String[] charToHex(String message)
	{
		String[] hexArray = new String[message.length()];

		for(int i = 0; i < message.length(); i++)
        {
			hexArray[i] = "00" + String.format("%04x", ((int) message.charAt(i)));
        }

		return hexArray;
	}
    
    //This is the final modifier for preparing the String[] of hexcodes.
    public static String[] colorKey(String[] charHex)
    {
        String[] colorHex = new String[charHex.length];
        
        for(int counter = 0; counter < charHex.length; counter++)
        {
            colorHex[counter] = "ff" + charHex[counter];
        }
        
        return(colorHex);
    }
    
    //This method converts the hexadecimal code back into an RGB int.
	public static int hexStringToRGBInt(String hex)
    {        
        Color hexColor = new Color(
            Integer.valueOf(hex.substring( 2, 4 ), 16),
            Integer.valueOf(hex.substring( 4, 6 ), 16),
            Integer.valueOf(hex.substring( 6, 8 ), 16));
        
        int r = hexColor.getRed();
        int g = hexColor.getGreen();
        int b = hexColor.getBlue();
        
        return 0xFF000000 | r | g | b;
    }
    
    //This method converts a String array holding all the hex values back into characters and finally a String.
	public static String hexToString(String[] hexArray)
	{
        char[] secret = new char[hexArray.length];
        String tempString;
        String secretMsg = "";
        
        System.out.println(secret.length);
                                     
        for(int counter = 0; counter < hexArray.length; counter++)
        {
            tempString = hexArray[counter];
            secret[counter] = (char)Integer.parseInt(tempString.substring(2,tempString.length()));
            System.out.print(secret[counter]);
        }
        
        for(int counter = 0; counter < secret.length; counter++)
            secretMsg += Character.toString(secret[counter]);
                             
        return(secretMsg);
	}
*/
}