import { useState } from "react";
import api from '../../services/api'
import 

export default function Edit() {
    const [id, setId] = useState(0)
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [phone, setPhone] = useState("")

    const toEdit = {
        id: id,
        name: name,
        email: email,
        phone: phone
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
    }

    return(

    )
}