package co.edu.eam.ingesoft.pa2.clientedatacredito;

import javax.xml.ws.BindingProvider;

public class main {
	public static void main(String[] args) {

		DatacreditoService cliente = new DatacreditoService();
		Centralriego servicio = cliente.getCentralriesgo();

		BindingProvider bp = (BindingProvider) servicio;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/orderprocesor/centralriego");

		RespuestaScoreDataCreditoDTO resp = servicio.consultarCiudadano("EAM", TipoDocEnum.CEDULA, "123");
		
		if (resp.getCodigoResp().equals("00")) {
			System.out.println(resp.getConsulta().getCiudadano().getNombre());
			System.out.println(resp.getConsulta().getScore());
		}

	}

}
