import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ConsultaPessoas from './ConsultaPessoas';
import CadastroPessoa from './CadastroPessoa';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ConsultaPessoas />} />
        <Route path="/cadastro" element={<CadastroPessoa />} />
      </Routes>
    </Router>
  );
};

export default App;