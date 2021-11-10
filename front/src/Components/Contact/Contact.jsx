import { Contato, Info, Name, Id } from "./style"

export default function Contact(props) {

    return(
        <Contato>
            <Id>ID: {props.id}</Id>
            <Name>Nome: {props.name}</Name>
            <Info>Email: {props.email}</Info>
            <Info>Telefone: {props.phone}</Info>
        </Contato>
    )
}