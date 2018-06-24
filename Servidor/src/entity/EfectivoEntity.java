package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import net.sourceforge.jtds.jdbc.DateTime;

@Entity
@DiscriminatorValue("Efectivo")
public class EfectivoEntity extends PagoEntity  implements Serializable{

	
	

}
