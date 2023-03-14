import { render, fireEvent } from "@testing-library/react";
import { screen } from "@testing-library/dom";
import { Header } from "../index";
import { expect, vi } from "vitest";

const reload = window.location.reload;

beforeAll(() => {
    Object.defineProperty(window, 'location', {
        writable: true,
        value: { reload: vi.fn() }
    });
});

afterAll(() => {
    window.location.reload = reload;
});

it("Zara logo should exist", async () => {
    render(<Header />);

    expect(screen.getByTestId("zara-logo")).toBeDefined();
})

it("When click Zara logo refresh page", async () => {
    render(<Header />);

    await fireEvent.click(screen.getByTestId("zara-logo"))

    expect(window.location.reload).toBeCalledTimes(1);
})
