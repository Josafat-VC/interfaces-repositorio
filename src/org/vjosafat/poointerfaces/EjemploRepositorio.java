package org.vjosafat.poointerfaces;

import org.vjosafat.poointerfaces.modelo.Cliente;
import org.vjosafat.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repo = new ClienteListRepositorio();

        repo.crear(new Cliente("Josafat", "Villaseñor"));
        repo.crear(new Cliente("Jenifer", "Ortiz"));
        repo.crear(new Cliente("Andres", "Guzman"));
        repo.crear(new Cliente("Luis", "Medina"));

        System.out.println("===== Lista =====");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);


        System.out.println("===== paginable =====");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1,3);
        paginable.forEach(System.out::println);


        System.out.println("===== ordenar ascendente =====");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC);
        for (Cliente c: clientesOrdenAsc ) {
            System.out.println(c);
        }

        System.out.println("===== ordenar descendente =====");
        List<Cliente> clientesOrdenDesc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.DESC);
        for (Cliente c: clientesOrdenAsc ) {
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Cliente andresActualizar = new Cliente("Andres", "Perez");
        andresActualizar.setId(2);
        repo.editar(andresActualizar);

        Cliente andres = repo.porId(2);
        System.out.println(andres);


        System.out.println("===== eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);



    }
}
