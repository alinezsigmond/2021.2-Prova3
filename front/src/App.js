import './App.css';
import Index from './Pages/Index/Index';
import Cadastro from './Pages/Cadastro/Cadastro'
import { BrowserRouter as Router, Route } from 'react-router-dom';

function App() {
  return (
      <Router>
        <Route path='/' exact component={Index} />
        <Route path='/cadastro' exact component={Cadastro} />
      </Router>
  );
}

export default App;
