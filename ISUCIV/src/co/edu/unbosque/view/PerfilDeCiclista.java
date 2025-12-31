package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDeCiclista.
 */
public class PerfilDeCiclista extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5253321276590340678L;
	
	/** The layout cartas. */
	private CardLayout layoutCartas;
	
	/** The perfil de ciclista escalador. */
	private PerfilDeCiclistaEscalador perfilDeCiclistaEscalador;
	
	/** The perfil de ciclista rodador. */
	private PerfilDeCiclistaRodador perfilDeCiclistaRodador;
	
	/** The perfil de ciclista embalador. */
	private PerfilDeCiclistaEmbalador perfilDeCiclistaEmbalador;
	
	/** The perfil de ciclista gregario. */
	private PerfilDeCiclistaGregario perfilDeCiclistaGregario;
	
	/** The perfil de ciclista clasicomano. */
	private PerfilDeCiclistaClasicomano perfilDeCiclistaClasicomano;
	
	/** The perfil de ciclista contrarrelojista. */
	private PerfilDeCiclistaContrarrelojista perfilDeCiclistaContrarrelojista;

	/**
	 * Instantiates a new perfil de ciclista.
	 */
	public PerfilDeCiclista() {
		setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1, 6));

		JButton botonEscalador = new JButton("Escalador");
		JButton botonRodador = new JButton("Rodador");
		JButton botonEmbalador = new JButton("Embalador");
		JButton botonGregario = new JButton("Gregario");
		JButton botonClasicomano = new JButton("Clasicomano");
		JButton botonContrarrelojista = new JButton("Contrarrelojista");

		panelNorte.add(botonEscalador);
		panelNorte.add(botonRodador);
		panelNorte.add(botonEmbalador);
		panelNorte.add(botonGregario);
		panelNorte.add(botonClasicomano);
		panelNorte.add(botonContrarrelojista);

		add(panelNorte, BorderLayout.NORTH);

		layoutCartas = new CardLayout();
		JPanel panelCentral = new JPanel(layoutCartas);

		perfilDeCiclistaEscalador = new PerfilDeCiclistaEscalador();
		perfilDeCiclistaRodador = new PerfilDeCiclistaRodador();
		perfilDeCiclistaEmbalador = new PerfilDeCiclistaEmbalador();
		perfilDeCiclistaGregario = new PerfilDeCiclistaGregario();
		perfilDeCiclistaClasicomano = new PerfilDeCiclistaClasicomano();
		perfilDeCiclistaContrarrelojista = new PerfilDeCiclistaContrarrelojista();

		panelCentral.add(perfilDeCiclistaEscalador, "Escalador");
		panelCentral.add(perfilDeCiclistaRodador, "Rodador");
		panelCentral.add(perfilDeCiclistaEmbalador, "Embalador");
		panelCentral.add(perfilDeCiclistaGregario, "Gregario");
		panelCentral.add(perfilDeCiclistaClasicomano, "Clasicomano");
		panelCentral.add(perfilDeCiclistaContrarrelojista, "Contrarrelojista");

		add(panelCentral, BorderLayout.CENTER);

		botonEscalador.addActionListener(e -> layoutCartas.show(panelCentral, "Escalador"));
		botonRodador.addActionListener(e -> layoutCartas.show(panelCentral, "Rodador"));
		botonEmbalador.addActionListener(e -> layoutCartas.show(panelCentral, "Embalador"));
		botonGregario.addActionListener(e -> layoutCartas.show(panelCentral, "Gregario"));
		botonClasicomano.addActionListener(e -> layoutCartas.show(panelCentral, "Clasicomano"));
		botonContrarrelojista.addActionListener(e -> layoutCartas.show(panelCentral, "Contrarrelojista"));
	}

	/**
	 * Gets the layout cartas.
	 *
	 * @return the layout cartas
	 */
	public CardLayout getLayoutCartas() {
		return layoutCartas;
	}

	/**
	 * Sets the layout cartas.
	 *
	 * @param layoutCartas the new layout cartas
	 */
	public void setLayoutCartas(CardLayout layoutCartas) {
		this.layoutCartas = layoutCartas;
	}

	/**
	 * Gets the perfil de ciclista escalador.
	 *
	 * @return the perfil de ciclista escalador
	 */
	public PerfilDeCiclistaEscalador getPerfilDeCiclistaEscalador() {
		return perfilDeCiclistaEscalador;
	}

	/**
	 * Sets the perfil de ciclista escalador.
	 *
	 * @param perfilDeCiclistaEscalador the new perfil de ciclista escalador
	 */
	public void setPerfilDeCiclistaEscalador(PerfilDeCiclistaEscalador perfilDeCiclistaEscalador) {
		this.perfilDeCiclistaEscalador = perfilDeCiclistaEscalador;
	}

	/**
	 * Gets the perfil de ciclista rodador.
	 *
	 * @return the perfil de ciclista rodador
	 */
	public PerfilDeCiclistaRodador getPerfilDeCiclistaRodador() {
		return perfilDeCiclistaRodador;
	}

	/**
	 * Sets the perfil de ciclista rodador.
	 *
	 * @param perfilDeCiclistaRodador the new perfil de ciclista rodador
	 */
	public void setPerfilDeCiclistaRodador(PerfilDeCiclistaRodador perfilDeCiclistaRodador) {
		this.perfilDeCiclistaRodador = perfilDeCiclistaRodador;
	}

	/**
	 * Gets the perfil de ciclista embalador.
	 *
	 * @return the perfil de ciclista embalador
	 */
	public PerfilDeCiclistaEmbalador getPerfilDeCiclistaEmbalador() {
		return perfilDeCiclistaEmbalador;
	}

	/**
	 * Sets the perfil de ciclista embalador.
	 *
	 * @param perfilDeCiclistaEmbalador the new perfil de ciclista embalador
	 */
	public void setPerfilDeCiclistaEmbalador(PerfilDeCiclistaEmbalador perfilDeCiclistaEmbalador) {
		this.perfilDeCiclistaEmbalador = perfilDeCiclistaEmbalador;
	}

	/**
	 * Gets the perfil de ciclista gregario.
	 *
	 * @return the perfil de ciclista gregario
	 */
	public PerfilDeCiclistaGregario getPerfilDeCiclistaGregario() {
		return perfilDeCiclistaGregario;
	}

	/**
	 * Sets the perfil de ciclista gregario.
	 *
	 * @param perfilDeCiclistaGregario the new perfil de ciclista gregario
	 */
	public void setPerfilDeCiclistaGregario(PerfilDeCiclistaGregario perfilDeCiclistaGregario) {
		this.perfilDeCiclistaGregario = perfilDeCiclistaGregario;
	}

	/**
	 * Gets the perfil de ciclista clasicomano.
	 *
	 * @return the perfil de ciclista clasicomano
	 */
	public PerfilDeCiclistaClasicomano getPerfilDeCiclistaClasicomano() {
		return perfilDeCiclistaClasicomano;
	}

	/**
	 * Sets the perfil de ciclista clasicomano.
	 *
	 * @param perfilDeCiclistaClasicomano the new perfil de ciclista clasicomano
	 */
	public void setPerfilDeCiclistaClasicomano(PerfilDeCiclistaClasicomano perfilDeCiclistaClasicomano) {
		this.perfilDeCiclistaClasicomano = perfilDeCiclistaClasicomano;
	}

	/**
	 * Gets the perfil de ciclista contrarrelojista.
	 *
	 * @return the perfil de ciclista contrarrelojista
	 */
	public PerfilDeCiclistaContrarrelojista getPerfilDeCiclistaContrarrelojista() {
		return perfilDeCiclistaContrarrelojista;
	}

	/**
	 * Sets the perfil de ciclista contrarrelojista.
	 *
	 * @param perfilDeCiclistaContrarrelojista the new perfil de ciclista contrarrelojista
	 */
	public void setPerfilDeCiclistaContrarrelojista(PerfilDeCiclistaContrarrelojista perfilDeCiclistaContrarrelojista) {
		this.perfilDeCiclistaContrarrelojista = perfilDeCiclistaContrarrelojista;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
