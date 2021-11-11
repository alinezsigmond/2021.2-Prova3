import { Contato, Info, Name, Id } from "./style"

export default function Contact(props) {

    return(
        <Contato>
            <Id name='id' data-testid='id'>ID: {props.id}</Id>
            <Name name='nome'>Nome: {props.name}</Name>
            <Info name='email'>Email: {props.email}</Info>
            <Info name='phone'>Telefone: {props.phone}</Info>
        </Contato>
    )
}