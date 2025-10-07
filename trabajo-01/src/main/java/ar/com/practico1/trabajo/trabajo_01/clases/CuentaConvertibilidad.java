package ar.com.practico1.trabajo.trabajo_01.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends CuentaCorriente {
    private double saldoDolares;//Unico atributo
    
    public CuentaConvertibilidad (int numero, Cliente clienteEmpresa, double saldo, double montoGiroDesc){
        super(numero, clienteEmpresa, saldo, montoGiroDesc);
    }

    //Validacion para permitir el ingreso de clientes empresariales (NUEVO)
    
    public void setCliente(Cliente clienteEmpresa) {
        if (clienteEmpresa instanceof ClienteEmpresa) {
            super.setClienteAsociado(clienteEmpresa);
        } else {
            System.out.println("Solo se pueden asignar Clientes Empresa");
        }
    }

    //Medoto para convertir a dolares

    public void convertirADolares(double tipoCambio) {
        saldoDolares += getSaldo() / tipoCambio;
        setSaldo(0);
    }

    //Metodo para reconvertir a pesos Argentinos
    public void convertirDolaresAPesos(double tipoCambio) {
        double pesosYaConvertidos = saldoDolares * tipoCambio;// Convierte dólares a pesos
        setSaldo(getSaldo() + pesosYaConvertidos);// Agrega los pesos convertidos al saldo de la cuenta
        saldoDolares = 0;// Pone el saldo en dólares a 0 después de convertir
    }

    //Medoto depositar dolares

    public void depositarDolares(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo");
        } else {
            saldoDolares += monto;
        }
    }

    //Metodo extraer dolares

    public void extraerDolares(double monto) {
        if (saldoDolares - monto < 0) {
            System.out.println("El monto a extraer excede el saldo en dolares");
        } else {
            saldoDolares -= monto;
        }
    }
}
