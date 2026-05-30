package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    private JLabel labNombre;
    private JLabel labCalificacion;
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
        setLayout( new GridLayout( 3, 1 ) );
        setBorder( new TitledBorder( "" ) );

        // Fila nombre
        JPanel panelNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelNombre.add( new JLabel( "Nombre: " ) );
        labNombre = new JLabel( "" );
        panelNombre.add( labNombre );
        add( panelNombre );

        // Fila calificación
        JPanel panelCalif = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelCalif.add( new JLabel( "Calificación: " ) );
        labCalificacion = new JLabel( "" );
        panelCalif.add( labCalificacion );
        add( panelCalif );

        // Fila visitado
        JPanel panelVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelVisitado.add( new JLabel( "Visitado: " ) );
        chkVisitado = new JCheckBox( );
        chkVisitado.setEnabled( false );
        panelVisitado.add( chkVisitado );
        add( panelVisitado );
    }

    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( buscarIconoCalificacion( calificacion ) );
        labCalificacion.setText( "" );
        chkVisitado.setSelected( visitado );
    }

    public void actualizarRestaurante( Restaurante r )
    {
        if( r != null )
            this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
