import { render, screen } from '@testing-library/react'
import Contact from '../Components/Contact/Contact'

describe("socorro", () => {
    test("deve passar", () => {
        render(<Contact />);
        const id = screen.getByTestId("id");
        expect(id).toBeInTheDocument;
    })
})