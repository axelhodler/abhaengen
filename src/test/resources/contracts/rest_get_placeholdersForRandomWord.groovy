package co.hodler.hang

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method GET()

        url("/game")
    }

    response {
        status 200
        body([
            placeholder: "____"
        ])
    }
}
