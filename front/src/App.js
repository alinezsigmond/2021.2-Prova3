import './App.css';
import Index from './Pages/Index/Index';
import Cadastro from './Pages/Cadastro/Cadastro'
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Delete from './Pages/Delete/Delete';
import Listar from './Pages/Listar/Listar';
import Editar from './Pages/Editar/Editar';

function App() {
  return (
      <Router>
        <Route path='/' exact component={Index} />
        <Route path='/cadastro' exact component={Cadastro} />
        <Route path='/delete' exact component={Delete} />
        <Route path='/listar' exact component={Listar} />
        <Route path='/editar' exact component={Editar} />
      </Router>
  );
}

export default App;
