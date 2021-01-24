import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Project extends Applet implements MouseListener {
    int click = 2, n, m, i = 0;
    char c[] = new char[10];
    TextField tf;
    Font f, a;
    Label l1;

    public void init() {
        setBackground(Color.cyan);
        setLayout(null);
        f = new Font("Algerian", Font.BOLD, 22);
        a = new Font("Jokerman", Font.ITALIC, 22);
        tf = new TextField(12);
        tf.setFont(f);
        tf.setEditable(false);
        l1 = new Label("Result:-");
        l1.setFont(a);
        add(l1);
        add(tf);
        tf.setBounds(770, 450, 100, 35);
        l1.setBounds(670, 460, 80, 25);
    }

    public void start() {
        addMouseListener(this);
        for (i = 0; i < 9; i++)
            c[i] = 'N';
    }

    public void paint(Graphics g) {
        Image im = getImage(getCodeBase(), "board.jpg");
        g.drawImage(im, 0, 0, this);
        Image im1 = getImage(getCodeBase(), "cover.jpg");
        g.drawImage(im1, 600, 0, this);
    }

    public void mouseClicked(MouseEvent me) {
        Graphics g = getGraphics();
        click--;
        int x = me.getX();
        int y = me.getY();
        if (click == 1) {
            if ((x > 700 && x < 800) && (y > 490 && y < 520)) {
                c[9] = 'G';
            }
            if (x < 200 && y < 200) {
                m = 0;
                n = 0;
                c[0] = 'X';
            }
            if ((x > 200 && x < 400) && (y < 200)) {
                m = 200;
                n = 0;
                c[1] = 'X';
            }
            if ((x > 400 && x < 600) && (y < 200)) {
                m = 400;
                n = 0;
                c[2] = 'X';
            }
            if (x < 200 && (y > 200 && y < 400)) {
                m = 0;
                n = 200;
                c[3] = 'X';
            }
            if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
                m = 200;
                n = 200;
                c[4] = 'X';
            }
            if ((x > 400 && x < 600) && (y > 200 && y < 400)) {
                m = 400;
                n = 200;
                c[5] = 'X';
            }
            if (x < 200 && (y > 400 && y < 600)) {
                m = 0;
                n = 400;
                c[6] = 'X';
            }
            if ((x > 200 && x < 400) && (y > 400 && y < 600)) {
                m = 200;
                n = 400;
                c[7] = 'X';
            }
            if ((x > 400 && x < 600) && (y > 400 && y < 600)) {
                m = 400;
                n = 400;
                c[8] = 'X';
            }
            g.setColor(Color.red);
            g.drawLine(m, n, m + 199, n + 199);
            g.drawLine(m + 199, n, m, n + 199);
        }
        if (click == 0) {
            if ((x > 670 && x < 900) && (y > 490 && y < 520)) {
                c[9] = 'G';
            }
            if (x < 200 && y < 200) {
                m = 0;
                n = 10;
                c[0] = 'O';
            }
            if ((x > 200 && x < 400) && (y < 200)) {
                m = 200;
                n = 10;
                c[1] = 'O';
            }
            if ((x > 400 && x < 600) && (y < 200)) {
                m = 400;
                n = 10;
                c[2] = 'O';
            }
            if (x < 200 && (y > 200 && y < 400)) {
                m = 0;
                n = 200;
                c[3] = 'O';
            }
            if ((x > 200 && x < 400) && (y > 200 && y < 400)) {
                m = 200;
                n = 200;
                c[4] = 'O';
            }
            if ((x > 400 && x < 600) && (y > 200 && y < 400)) {
                m = 400;
                n = 200;
                c[5] = 'O';
            }
            if (x < 200 && (y > 400 && y < 600)) {
                m = 0;
                n = 400;
                c[6] = 'O';
            }
            if ((x > 200 && x < 400) && (y > 400 && y < 600)) {
                m = 200;
                n = 400;
                c[7] = 'O';
            }
            if ((x > 400 && x < 600) && (y > 400 && y < 600)) {
                m = 400;
                n = 400;
                c[8] = 'O';
            }
            g.setColor(Color.blue);
            g.drawOval(m + 10, n + 10, 169, 169);
            click = click + 2;
        }
        if (c[i] == 'G') {
            // System.exit(0);
            repaint();
        }
        for (i = 0; i < 9; i++) {
            if (c[i] != 'N') {
                if (i == 8)
                    tf.setText("TIED");
            } else
                break;
        }
        for (i = 0; i < 3; i++) {
            if (c[i] == 'X') {
                if ((c[i + 3] == c[i]) && (c[i + 6] == c[i]))
                    tf.setText("X WON");
            }
        }
        for (i = 0; i < 7; i++) {
            if (c[i] == 'X') {
                if ((c[i] == c[i + 1]) && (c[i] == c[i + 2]))
                    tf.setText("X WON");
                i = i + 2;
            } else
                i = i + 2;
        }
        if (c[4] == 'X') {
            if (((c[0] == c[4]) && (c[4] == c[8])) || ((c[2] == c[4]) && (c[4] == c[6])))
                tf.setText("X WON");
        }
        for (i = 0; i < 3; i++) {
            if (c[i] == 'O') {
                if ((c[i + 3] == c[i]) && (c[i + 6] == c[i]))
                    tf.setText("O WON");
            }
        }
        for (i = 0; i < 7; i++) {
            if (c[i] == 'O') {
                if ((c[i] == c[i + 1]) && (c[i] == c[i + 2]))
                    tf.setText("O WON");
                i = i + 2;
            } else
                i = i + 2;
        }
        if (c[4] == 'O') {
            if (((c[0] == c[4]) && (c[4] == c[8])) || ((c[2] == c[4]) && (c[4] == c[6])))
                tf.setText("O WON");
        }
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }
}
/*
 * <applet code="Project" width=1000 height=600> </applet>
 */
