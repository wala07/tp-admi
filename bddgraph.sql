-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 06 mars 2023 à 15:59
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bddgraph`
--

-- --------------------------------------------------------

--
-- Structure de la table `bac`
--

CREATE TABLE `bac` (
  `idBac` int(11) NOT NULL,
  `libelle` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bac`
--

INSERT INTO `bac` (`idBac`, `libelle`) VALUES
(1, 'bacgeneral'),
(2, 'bacSTI2D'),
(3, 'bacpro');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `idEtu` int(50) NOT NULL,
  `nom` varchar(35) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `dateNaiss` date NOT NULL,
  `lieuNaiss` varchar(50) NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `nationalite` varchar(50) NOT NULL,
  `rue` varchar(50) NOT NULL,
  `cp` varchar(50) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `mail` varchar(20) NOT NULL,
  `niveau` varchar(20) NOT NULL,
  `idFil` int(11) NOT NULL,
  `idBac` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `idFil` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`idFil`, `nom`) VALUES
(1, 'Professionnel '),
(2, 'General'),
(3, 'STI2D');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `mail`, `login`, `password`) VALUES
(1, 'votrenom@infos.net', 'votrenom', 'votrepass');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bac`
--
ALTER TABLE `bac`
  ADD PRIMARY KEY (`idBac`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`idEtu`),
  ADD KEY `ContraireEtudiantBac` (`idBac`),
  ADD KEY `ContranteEtudiantFiliere` (`idFil`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`idFil`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bac`
--
ALTER TABLE `bac`
  MODIFY `idBac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `idEtu` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `idFil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `ContraireEtudiantBac` FOREIGN KEY (`idBac`) REFERENCES `bac` (`idBac`),
  ADD CONSTRAINT `ContranteEtudiantFiliere` FOREIGN KEY (`idFil`) REFERENCES `filiere` (`idFil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
