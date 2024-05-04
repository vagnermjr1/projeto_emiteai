import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ConsultaPessoas from './ConsultaPessoas';
import PersonForm from './PersonForm';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ConsultaPessoas />} />
        <Route path="/cadastro" element={<PersonForm />} />
      </Routes>
    </Router>
  );
};

export default App;