import {Options, StyledH1, StyledH2} from './style'  
import { Link } from 'react-router-dom'

export default function Index() {
    return(
        <>
        <StyledH1>Olá, meu anjo.</StyledH1>
        <StyledH2>O que deseja fazer?</StyledH2>
        <Options>
            <Link to='/cadastro'>Cadastrar contato</Link>
            <p>Opçãozinha 2</p>
            <p>Opçãozinha 3</p>
            <p>Opçãozinha 4</p>
        </Options>
        </>
    )
}