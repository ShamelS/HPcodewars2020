import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob25 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String[][] map = new String[100][100]; //start from col 1 and row 1
        int totalSectors = in.nextInt();
        int jumpCount = in.nextInt();
        String[] jumps = new String[jumpCount];
        int maxX = 0; int maxY = 0;

        for(int i = 0; i < totalSectors; i++) {
            String coord = in.next();
            String sectorName = in.next();

            int yCoord = Integer.parseInt(coord.substring(0, 2));
            int xCoord = Integer.parseInt(coord.substring(2, 4));

            if(xCoord > maxX)
                maxX = xCoord;
            if(yCoord > maxY)
                maxY = yCoord;

            map[xCoord][yCoord] = sectorName;
        }

        in.nextLine();
        for(int i = 0; i < jumpCount; i++) {
            jumps[i] = in.nextLine();
        }
        in.close();

        for(int k = 0; k < jumpCount; k++) {
            //process jump names
            String[] startEnd = jumps[k].split(" "); //startEnd[0] = start, startEnd[1] = end
            int startX = 0, startY = 0, endX = 0, endY = 0;
            boolean foundStart = false;
            boolean foundEnd = false;

            //find coord of start/end
            for(int i = 1; i <= maxX; i++) {
                for(int j = 1; j <= maxY; j++) {
                    if(map[i][j] != null) {
                        if(map[i][j].equals(startEnd[0])) {
                            startX = j;
                            startY = i;
                            foundStart = true;
                        } else if(map[i][j].equals(startEnd[1])) {
                            endX = j;
                            endY = i;
                            foundEnd = true;
                        }
                    }
                    if(foundEnd && foundStart) {
                        break;
                    }
                }
                if(foundEnd && foundStart) {
                    break;
                }
            }

            //calculate distance
            /*
                distance is calculated by adding the diagnal distance between the 2 points and the remaining "axis" (along y or x axis) distance
             */

            int distance = 0;
            int deltaX = 0;
            int deltaY = 0;
            if(startX < endX) { //going left to right
                //try to find diagonal distance
                if(startY < endY) { //going top to down
                    while(startX+deltaX < endX && startY+deltaY < endY) {
//                        System.out.println((startX + deltaX) + " " + ((startX + deltaX) % 2 != 0));
                        if((startX + deltaX) % 2 != 1) {
                            deltaY++;
                        }
                        deltaX++;

                    }
                } else { //going down to top
                    while(startX+deltaX < endX && startY+deltaY > endY) {
                        if((startX + deltaX) %2 != 0) {
                            deltaY--;
                        }
                        deltaX++;
                    }
                }
            } else { //going right to left
                if(startY < endY) { //going top to down
                    while(startX+deltaX > endX && startY+deltaY < endY) {
                        if((startX + deltaX) %2 != 1) {
                            deltaY++;
                        }
                        deltaX--;
                    }
                } else { //going down to top
                    while(startX+deltaX > endX && startY+deltaY > endY) {
                        if((startX + deltaX) %2 != 0) {
                            deltaY--;
                        }
                        deltaX--;
                    }
                }
            }

//            System.out.println(deltaX + " "  +deltaY);
            distance += Math.abs(deltaX); //only one delta needed (since diagonal movement counts as one move)

            if(startX + deltaX != endX || startY + deltaY != endY) {
                if(startX + deltaX == endX) { //this means on the same column
                    distance += Math.abs((startY + deltaY) - endY);

                } else { //this means on the same row
                    distance += Math.abs((startX + deltaX) - endX);
                }
            }

            /*
            distance += Math.abs(startX-endX); //x distance

            if(Math.abs(startY-endY)>0)
                distance += Math.abs(startY-endY) - (distance/2); //y distance (the subtraction part here takes diagnals into consideration so that the calculation doesnt "double count" on a sector

             */
            System.out.println(startEnd[0] +" "+ startEnd[1] + " " + distance);
        }
    }
}
