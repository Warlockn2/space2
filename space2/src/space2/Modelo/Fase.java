package space2.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener {

	/* Criação da classe "fase" e dos graficos que irão aparecer na janela */

	private Image fundo;
	private Player player;
	private Timer timer;

	public Fase() {

		/* Otimização da janela de graficos na tela */

		setFocusable(true);
		setDoubleBuffered(true);

		/* Adicionando imagem de fundo da fase */

		ImageIcon referencia = new ImageIcon("res/black_space1280.png");
		fundo = referencia.getImage();

		/* Chamando a classe "Player" e printando ela na tela, dentro de "Fase" */

		player = new Player();
		player.load();

		/* Adicionando interação do teclado: */

		addKeyListener(new TecladoAdapter());

		/* Setando configuração de tempo e atualização da tela de fase */

		timer = new Timer(5, this);
		timer.start();
	}

	public void paint(Graphics g) {

		/* Configuração de print da imagem na tela */

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

		List<Tiro> tiros = player.getTiros();

		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}
		g.dispose();

	}

	/* Atualização da localização na tela: */

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		List<Tiro> tiros = player.getTiros();

		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
			} else {
				tiros.remove(i);
			}
		}
		repaint();
	}

	/* ?: */

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

			player.keyRelease(e);
		}

	}

}
