package Board;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VisualizeBoard extends JPanel{

    static long whitePawns, whiteRooks, whiteBishops, whiteKnights, whiteQueens, whiteKing;
    static long blackPawns, blackRooks, blackBishops, blackKnights, blackQueens, blackKing;
    static long[] bitBoards;
    static int humanWhite = 1;
    static int border = 20;
    static double squareSize = 64;
    static JFrame gameFrame = new JFrame("Rook Roller GUI");
    static VisualizeBoard visualization = new VisualizeBoard();



    public static void main(String[] args) {
        gameFrame.setVisible(true);
        gameFrame.add(visualization);
        gameFrame.setSize(new Dimension(900, 900));
        gameFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - gameFrame.getWidth())/2, (Toolkit.getDefaultToolkit().getScreenSize().height - gameFrame.getHeight())/2);

        newGame();
        gameFrame.repaint();

    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.setBackground(new Color(141, 177, 171));
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                squareSize = (double) (Math.min(getHeight(), getWidth() - 200 -border)-2 * border)/8;

            }
        });

        drawBoard(graphics);
        try {
            drawPiece(graphics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawBoard(Graphics g){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // Determine the color based on the row and column
                if ((row + col) % 2 == 0) {
                    g.setColor(new Color(231, 215, 193)); // Light color
                } else {
                    g.setColor(new Color(40, 75, 99)); // Dark color
                }
                g.fillRect(col * (int) squareSize + border, row * (int) squareSize + border, (int) squareSize, (int) squareSize);
            }
        }
    }


    public void drawPiece(Graphics g) throws IOException {

        Graphics2D g2d = (Graphics2D) g; // Use Graphics2D for better rendering
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        Image[] pieces;
        String workingDir = System.getProperty("user.dir") + "\\src\\Board\\ChessPieceIcons";
        System.out.println(workingDir);
        BufferedImage img;
        pieces = new Image[]{new ImageIcon(workingDir + "\\wp.png").getImage(), new ImageIcon(workingDir + "\\wr.png").getImage(), new ImageIcon(workingDir + "\\wn.png").getImage(),
                new ImageIcon(workingDir + "\\wb.png").getImage(), new ImageIcon(workingDir + "\\wq.png").getImage(), new ImageIcon(workingDir + "\\wk.png").getImage(),
                new ImageIcon(workingDir + "\\bp.png").getImage(), new ImageIcon(workingDir + "\\br.png").getImage(), new ImageIcon(workingDir + "\\bn.png").getImage(),
                new ImageIcon(workingDir + "\\bb.png").getImage(), new ImageIcon(workingDir + "\\bq.png").getImage(), new ImageIcon(workingDir + "\\bk.png").getImage()};


        for (int i = 0; i < 64; i++) {
            int x = (i % 8) * (int) squareSize + border;
            int y = (i / 8) * (int) squareSize + border;

            for (int pieceIndex = 0; pieceIndex < 12; pieceIndex++) {
                if (((bitBoards[pieceIndex] >> i) & 1) == 1) {
                    if(pieces[pieceIndex] == null){
                        System.out.println("ERROR");
                    }
                    //pieces[pieceIndex] = ImageIO.read(new File(workingDir + "\\wp.png"));
                    System.out.println(workingDir + "\\wp.png");
                    g2d.drawImage(pieces[pieceIndex], x, y, (int) squareSize, (int) squareSize, null);
                }
            }
        }

    }

    public static void newGame(){
        bitBoards = Board.initializeBoard();
        System.out.println(Arrays.toString(bitBoards));
    }

}
