import React, { useState } from 'react';
import axios from 'axios';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import InputMask from 'react-input-mask';
import { Link } from 'react-router-dom';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';
import './CadastroPessoa.css';

const CadastroPessoa = () => {
  const [formData, setFormData] = useState({
    nome: '',
    telefone: '',
    cpf: '',
    endereco: {
      cep: '',
      numero: '',
      complemento: '',
      bairro: '',
      cidade: '',
      estado: '',
    },
  });

  const [bairroEditable, setBairroEditable] = useState(false);
  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [snackbarSeverity, setSnackbarSeverity] = useState('');
  const [snackbarMessage, setSnackbarMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleChangeEndereco = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      endereco: {
        ...prevData.endereco,
        [name]: value,
      },
    }));
  };

  const handleCEPChange = async (e) => {
    const cep = e.target.value;
    setFormData((prevData) => ({
      ...prevData,
      endereco: {
        ...prevData.endereco,
        cep: cep,
      },
    }));
    if (cep.replace(/\D/g, '').length === 8) {
      try {
        const response = await axios.get(`https://viacep.com.br/ws/${cep}/json/`);
        const { data } = response;
        if (data.erro) {
          showSnackbar('error', 'CEP não encontrado. Por favor, verifique o CEP digitado.');
          return;
        }
        setFormData((prevData) => ({
          ...prevData,
          endereco: {
            ...prevData.endereco,
            bairro: data.bairro || '',
            cidade: data.localidade,
            estado: data.uf,
          },
        }));
        setBairroEditable(true);
      } catch (error) {
        console.error('Erro ao consultar CEP:', error);
        showSnackbar('error', 'Erro ao consultar CEP. Por favor, verifique sua conexão de internet.');
      }
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put('http://localhost:8080/cadastro/pessoa', formData);
      showSnackbar('success', 'Cadastro realizado com sucesso');
      clearForm();
    } catch (error) {
      showSnackbar('error', error.response.data);
    }
  };

  const clearForm = () => {
    setFormData({
      nome: '',
      telefone: '',
      cpf: '',
      endereco: {
        cep: '',
        numero: '',
        complemento: '',
        bairro: '',
        cidade: '',
        estado: '',
      },
    });
    setBairroEditable(false);
  };

  const showSnackbar = (severity, message) => {
    setSnackbarSeverity(severity);
    setSnackbarMessage(message);
    setSnackbarOpen(true);
  };

  const handleSnackbarClose = () => {
    setSnackbarOpen(false);
  };

  return (
    <div className="form-container">
      <div className="centered-container">
        <h2>Cadastro de Pessoa</h2>
      </div>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label className="form-label">Informações Pessoais</label>
          <div className="row">
            <TextField
              label="Nome"
              name="nome"
              value={formData.nome}
              onChange={handleChange}
              fullWidth
              margin="normal"
            />
            <InputMask
              mask="(99) 99999-9999"
              name="telefone"
              value={formData.telefone}
              onChange={handleChange}
            >
              {(inputProps) => <TextField {...inputProps} label="Telefone" fullWidth margin="normal" />}
            </InputMask>
            <InputMask
              mask="999.999.999-99"
              name="cpf"
              value={formData.cpf}
              onChange={handleChange}
            >
              {(inputProps) => <TextField {...inputProps} label="CPF" fullWidth margin="normal" />}
            </InputMask>
          </div>
        </div>
        <div className="form-group">
          <label className="form-label">Endereço</label>
          <div className="row">
            <InputMask
              mask="99999-999"
              value={formData.endereco.cep}
              onChange={handleCEPChange}
            >
              {(inputProps) => <TextField {...inputProps} label="CEP" fullWidth margin="normal" />}
            </InputMask>
            <TextField
              label="Número"
              name="numero"
              value={formData.endereco.numero}
              onChange={handleChangeEndereco}
              fullWidth
              margin="normal"
            />
          </div>
          <div className="row">
            <TextField
              label="Complemento"
              name="complemento"
              value={formData.endereco.complemento}
              onChange={handleChangeEndereco}
              fullWidth
              margin="normal"
            />
            {bairroEditable ? (
              <TextField
                label="Bairro"
                name="bairro"
                value={formData.endereco.bairro}
                onChange={handleChangeEndereco}
                fullWidth
                margin="normal"
              />
            ) : (
              <TextField
                label="Bairro"
                name="bairro"
                value={formData.endereco.bairro}
                fullWidth
                margin="normal"
                disabled
              />
            )}
            <TextField
              label="Município"
              name="cidade"
              value={formData.endereco.cidade}
              fullWidth
              margin="normal"
              disabled
            />
            <TextField
              label="Estado"
              name="estado"
              value={formData.endereco.estado}
              fullWidth
              margin="normal"
              disabled
            />
          </div>
        </div>
        <div className="centered-container">
          <Link to="/">
            <Button variant="contained">Voltar</Button>
          </Link>
          <Button type="submit" variant="contained" color="primary">
            Cadastrar
          </Button>
        </div>
      </form>
      <Snackbar
        open={snackbarOpen}
        autoHideDuration={6000}
        onClose={handleSnackbarClose}
        anchorOrigin={{ vertical: 'top', horizontal: 'right' }}
      >
        <MuiAlert
          elevation={6}
          variant="filled"
          onClose={handleSnackbarClose}
          severity={snackbarSeverity}
        >
          {snackbarMessage}
        </MuiAlert>
      </Snackbar>
    </div>
  );
};

export default CadastroPessoa;
