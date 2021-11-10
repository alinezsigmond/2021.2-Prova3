import { useState } from "react"
import api from '../../services/api'
import { Form, Label, Input, Button } from './style'

export default function Delete() {
    const [id, setId] = useState(0)

    const deletion = {
        id: id
    }

    async function handleSubmit(e) {
        e.preventDefault();
        await cadastrar(deletion);
    }

    async function cadastrar(deletion) {
        console.log(deletion);
        const response = await api.delete(
            '/contatos/'+id,
            deletion
        )
        console.log(response.status);
        if (response.status === 200) {
            alert("Contato deletado com sucesso!")
        } else {
            alert("Contato não encontrado")
        }
    }
    
    return(
        <Form 
        onSubmit={(e) => handleSubmit(e)}
        >
            <Label>
                Informe o ID do contato que deseja deletar:
                <Input
                type="number"
                name="id"
                onChange={value => setId(value.target.value)}
                value={id}
                />
            </Label>
            <Button type="submit" value="Deletar" />
        </Form>
    )
}