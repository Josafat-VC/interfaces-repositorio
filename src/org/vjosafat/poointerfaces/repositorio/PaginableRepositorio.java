package org.vjosafat.poointerfaces.repositorio;

import org.vjosafat.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
