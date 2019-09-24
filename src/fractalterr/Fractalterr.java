package fractalterr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Fractalterr extends JFrame implements KeyListener {
	int personx = 64;
	int persony = 64;
	boolean shift = false;
	boolean ctrl = false;
	int vert = 750;
	int hor = 500;
	static double OverR2 = 1 / Math.sqrt(2);
	double zoom = 5;
	double[] bob = fractal(8, 256);
	double[] dod = fractal(8, 256);
	double rot = 0;
	double[][] dbd = new double[257][257];
	double[][] frame = new double[128][128];
	boolean exiting = false;

	public Fractalterr() {
		addKeyListener(this);
		setSize(1500, 1000);
		setVisible(true);

	}

	public void paint(Graphics g) {
		
		for (double m = 0; m < 255; m++) {
			for (double h = 0; h < 255; h++) {
				int w = 0;

				dbd[(int) m][(int) h] = (int) (perlin.perl(m / 32, h / 32, frame) * 64);

			}
		}
		g.clearRect(0, 0, 2000, 1500);
		for (int m = -128; m < 126; m++) {
			for (int h = -128; h < 126; h++) {
				int m1 = m + 1;
				int h1 = h + 1;
				int z = (int) dbd[m + 128][h + 128];
				int a = 0;
				int b = 0;
				int c = 0;
				if (z < 40 && z > 20) {
					a = 0;
					b = 255;
					c = 0;
				}
				if (z < -50) {
					a = 255;
					b = 255;
					c = 0;
				}
				if (z > 40) {
					a = 128;
					b = 128;
					c = 128;
				}
				g.setColor(new Color(a, b, c));
				g.drawLine((int) (((Math.sin(rot) * m + Math.sin(rot + Math.PI / 2) * h) * zoom + hor)),
						(int) ((dbd[m + 128][h + 128] * 2 + sind(rot) * m + sind(rot + Math.PI / 2) * h) * zoom + vert),
						(int) (((Math.sin(rot) * m1 + Math.sin(rot + Math.PI / 2) * h) * zoom + hor)),
						(int) ((dbd[m1 + 128][h + 128] * 2 + sind(rot) * m1 + sind(rot + Math.PI / 2) * h) * zoom
								+ vert));
				g.drawLine((int) (((Math.sin(rot) * m + Math.sin(rot + Math.PI / 2) * h) * zoom + hor)),
						(int) ((dbd[m + 128][h + 128] * 2 + sind(rot) * m + sind(rot + Math.PI / 2) * h) * zoom + vert),
						(int) (((Math.sin(rot) * m + Math.sin(rot + Math.PI / 2) * h1) * zoom + hor)),
						(int) ((dbd[m + 128][h1 + 128] * 2 + sind(rot) * m + sind(rot + Math.PI / 2) * h1) * zoom
								+ vert));

			}
		}

	}

	public double[] fractal(int power, int number) {
		double[] d2 = new double[number + 1];
		int numb = number;
		for (int i = 0; i < power; i++) {

			numb = numb / 2;
			for (int e = numb; e < number + 1 - numb; e = e + numb * 2) {
				d2[e] = ((d2[e - numb + 0] + d2[e + numb + 0]) / 2) + (int) ((Math.random() - 0.5) * numb * 2.0);
			}
		}
		return d2;
	}

	public static void main(String[] args) {
		System.out.println();
		Fractalterr terr = new Fractalterr();
		for (;;) {
			if (terr.exiting) {
				System.exit(0);
			}
		}

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			hor = hor + 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			vert = vert - 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			hor = hor - 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			vert = vert + 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrl = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
			if (ctrl && shift) {
				zoom = zoom + 0.0001;
			} else if (ctrl && !shift) {
				zoom = zoom + 0.001;
			} else if (shift && !ctrl) {
				zoom = zoom + 0.1;
			} else {
				zoom = zoom + 0.01;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_COMMA) {
			if (ctrl && shift) {
				zoom = zoom - 0.0001;
			} else if (ctrl && !shift) {
				zoom = zoom - 0.001;
			} else if (shift && !ctrl) {
				zoom = zoom - 0.1;
			} else {
				zoom = zoom - 0.01;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (ctrl && shift) {
				rot = rot + 0.0001;
			} else if (ctrl && !shift) {
				rot = rot + 0.001;
			} else if (shift && !ctrl) {
				rot = rot + 0.1;
			} else {
				rot = rot + 0.01;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (ctrl && shift) {
				rot = rot - 0.0001;
			} else if (ctrl && !shift) {
				rot = rot - 0.001;
			} else if (shift && !ctrl) {
				rot = rot - 0.1;
			} else {
				rot = rot - 0.01;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_F5) {
			bob = fractal(8, 256);
			dod = fractal(8, 256);
			dbd = methods.ds(8);
			for (int m = 0; m < 126; m++) {
				for (int h = 0; h < 126; h++) {
					frame[m][h] = Math.random() * Math.PI;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.exit(ABORT);
				;
			}
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ctrl = false;
		}
	}

	public double sind(double x) {
		return Math.cos(x) * OverR2;
	}
}
