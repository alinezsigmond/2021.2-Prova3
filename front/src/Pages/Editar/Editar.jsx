import { useState } from "react"
import api from '../../services/api'
import { Form, Label, Input, Button } from './style'

export default function Editar() {
    const [id, setId] = useState(0);
    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");
    const [email, setEmail] = useState("");

    const toEdit = {
        id: id,
        name: name,
        phone: phone,
        email: email
    }

    async function handleSubmit(e) {
        e.preventDefault();
        await edit(toEdit);
    }

    async function edit(toEdit) {
        console.log(toEdit);
        const response = await api.put(
            '/contatos/'+id,
            toEdit
        )
        console.log(response.status);
        if (response.status === 200) {
            alert("Contato editado com sucesso!")
        } else {
            alert("Contato não encontrado")
        }
    }
    
    return(
        <Form 
        onSubmit={(e) => handleSubmit(e)}
        >
            <Label>
                Informe o ID e atualize os dados:
                <Input
                type="number"
                name="id"
                onChange={value => setId(value.target.value)}
                value={id}
                />
            </Label>
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
            <Button type="submit" value="Editar" />
        </Form>
    )
}