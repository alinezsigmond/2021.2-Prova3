import React, { useEffect, useState } from "react";
import Contact from "../../Components/Contact/Contact";
import api from '../../services/api'

export default function Listar() {
    const [results, setResults] = useState([])

    useEffect(() => {
        api.get('/contatos').then(response => setResults(response.data));
    }, []);

    return(
        <>
         { results.length !== 0 
                ?
                results.map(post => (
                    <Contact
                        id={post.id}
                        name={post.name}
                        email={post.email}
                        phone={post.phone}
                    />
                ))
                :
                <p>Nenhum contato encontrado</p>
            }
        </>
    )
}