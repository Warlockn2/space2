package space2.Modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.List;

public class Player {

	/* Configuraçao da disposição de espaço disponivel para movimento (em x e y) */

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Tiro> tiros;

	/* construtor "Player": */

	public Player() {

		this.x = 100;
		this.y = 100;

		tiros = new ArrayList<Tiro>();

	}

	/* Importação da imagem do personagem */

	public void load() {

		ImageIcon referencia = new ImageIcon("res/space100.png");
		imagem = referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

	}

	/* Atualização na tela depois da movimentação */

	public void update() {

		x += dx;
		y += dy;

	}

	/* declarando ca posição que o tiro irá sair da nave */
	public void tiroSimples() {

		this.tiros.add(new Tiro(x + largura, y + (altura / 2)));
	}

	/* Configuração e implementação das teclas de movimento */

	public void keyPressed(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_H) {

			tiroSimples();
		}

		if (codigo == KeyEvent.VK_W || codigo == KeyEvent.VK_UP) {

			dy = -3;
		}
		if (codigo == KeyEvent.VK_S || codigo == KeyEvent.VK_DOWN) {

			dy = 3;
		}
		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {

			dx = -3;
		}
		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {

			dx = 3;
		}

	}

	/* Configuração do controle das teclas sobre o que fazer quando soltar */

	public void keyRelease(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_W || codigo == KeyEvent.VK_UP) {

			dy = 0;
		}
		if (codigo == KeyEvent.VK_S || codigo == KeyEvent.VK_DOWN) {

			dy = 0;
		}
		if (codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {

			dx = 0;
		}
		if (codigo == KeyEvent.VK_D || codigo == KeyEvent.VK_RIGHT) {

			dx = 0;
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

}
