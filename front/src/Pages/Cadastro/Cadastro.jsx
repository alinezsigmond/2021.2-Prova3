import { useState } from "react"
import {Form, Input, Label, Button} from './style'
import api from '../../services/api'

export default function Cadastro(props) {
    const [name, setName] = useState("")
    const [phone, setPhone] = useState("");
    const [email, setEmail] = useState("");

    const cadastro = {
        name: name,
        phone: phone,
        email: email
    }

    async function handleSubmit(e) {
        e.preventDefault();
        await cadastrar(cadastro);
    }

    async function cadastrar(cadastro) {
        console.log(cadastro);
        const response = await api.post(
            '/contatos',
            cadastro
        )
        if (response.status === 201) {
            alert("Contato cadastrado com sucesso!")
        } else {
            alert("Contato já cadastrado")
        }
    }

    return(
        <Form 
        onSubmit={(e) => handleSubmit(e)}
        >
            <Label>
                Nome:
                <Input
                type="text"
                name="name"
                onChange={value => setName(value.target.value)}
                value={name}
                />
            </Label>
            <Label>
                Email:
                <Input
                type="text"
                name="email"
                onChange={value => setEmail(value.target.value)}
                value={email}
                />
            </Label>
            <Label>
                Telefone:
                <Input
                type="text"
                name="phone"
                onChange={value => setPhone(value.target.value)}
                value={phone}
                />
            </Label>

            <Button id="cadastrar" type="submit" value="Cadastrar" />
        </Form>
    )
}