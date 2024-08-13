-- Inserir usuários
INSERT INTO usuario (nome, email, senha_hash) VALUES
('Maria Silva', 'maria.silva@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('João Santos', 'joao.santos@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Ana Pereira', 'ana.pereira@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Carlos Lima', 'carlos.lima@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Luciana Alves', 'luciana.alves@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Pedro Souza', 'pedro.souza@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Carla Mendes', 'carla.mendes@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Bruno Costa', 'bruno.costa@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5'),
('Fernanda Lima', 'fernanda.lima@example.com', '1819aab14c4bed2d4f4476e4e5f1e598a59cbf72ca04840850c42738352a5d74ee2a90b8e1747957adac70a44a148c0193d3929af79ecda3074fc47f31e204c5');

INSERT INTO notas (email, nota) VALUES
('maria.silva@example.com', 5.6),
('maria.silva@example.com', 6.5),
('maria.silva@example.com', 5.6),
('maria.silva@example.com', 6.5);

INSERT INTO faltas (email, quantidade) VALUES
('maria.silva@example.com', 10);