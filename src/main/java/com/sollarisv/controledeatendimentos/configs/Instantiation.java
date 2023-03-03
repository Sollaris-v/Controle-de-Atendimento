package com.sollarisv.controledeatendimentos.configs;


import com.sollarisv.controledeatendimentos.models.Cliente;
import com.sollarisv.controledeatendimentos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner
{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public  void run(String... arg0) throws Exception
    {
        clienteRepository.deleteAll();

        Cliente cliente1 = new Cliente(null, "Fernanda Brito", "21967858425", "fernanda@gmail.com", 0);
        Cliente cliente2 = new Cliente(null, "Amanda Brito", "21967852325", "amandatrere@gmail.com", 150);
        Cliente cliente3 = new Cliente(null, "Carla Frost", "21967824525", "frostCa@gmail.com", 220);
        Cliente cliente4 = new Cliente(null, "Mario Hellscream", "21967856725", "screamario@gmail.com", 0);
        Cliente cliente5 = new Cliente(null, "Pedro Zumzum", "219123858425", "wanzumju@gmail.com", 40);

        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5));
    }

}
