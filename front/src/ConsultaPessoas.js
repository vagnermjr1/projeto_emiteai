import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Button from '@mui/material/Button';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { CSVLink } from 'react-csv';
import './ConsultaPessoas.css';

const ConsultaPessoas = () => {
  const [pessoas, setPessoas] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/cadastro/listar');
      setPessoas(response.data);
    } catch (error) {
      console.error('Erro ao obter pessoas:', error);
    }
  };

  const exportToCSV = () => {
    const csvData = pessoas.map(pessoa => ({
      nome: pessoa.nome,
      telefone: pessoa.telefone,
      cpf: pessoa.cpf,
      cep: pessoa.endereco.cep,
      numero: pessoa.endereco.numero,
      complemento: pessoa.endereco.complemento,
      bairro: pessoa.endereco.bairro,
      municipio: pessoa.endereco.municipio,
      estado: pessoa.endereco.estado
    }));
    return csvData;
  };

  return (
    <div className="consulta-pessoas-container">
      <h2 className="title">Consulta de Pessoas</h2>
      <div className="export-button">
        <CSVLink data={exportToCSV()} filename={"pessoas.csv"}>
          <Button variant="contained" color="primary">Exportar para CSV</Button>
        </CSVLink>
      </div>
      <TableContainer component={Paper}>
        <Table>
          <TableBody>
            {pessoas.map((pessoa) => (
              <TableRow key={pessoa.id}>
                <TableCell>{pessoa.nome}</TableCell>
                <TableCell>{pessoa.telefone}</TableCell>
                <TableCell>{pessoa.cpf}</TableCell>
                <TableCell>{pessoa.endereco.cep}</TableCell>
                <TableCell>{pessoa.endereco.numero}</TableCell>
                <TableCell>{pessoa.endereco.complemento}</TableCell>
                <TableCell>{pessoa.endereco.bairro}</TableCell>
                <TableCell>{pessoa.endereco.municipio}</TableCell>
                <TableCell>{pessoa.endereco.estado}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <div className="action-buttons">
        <Link to="/cadastro">
          <Button variant="contained" color="primary">Cadastrar Nova Pessoa</Button>
        </Link>
        <Button onClick={fetchData} variant="contained" color="primary">Consultar</Button>
      </div>
    </div>
  );
};

export default ConsultaPessoas;
